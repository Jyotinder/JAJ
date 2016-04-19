import os

class interp:
    def __init__(self,code):
        self.g_symtable={}
        self.gobal=[]
        self.EIP=0
        self.code=code
        self.datatype=['INT','FLOAT','BOOL']
        self.localstack={}
        self.callstack=[]
        self.funarg=[]
        self.debug=0
        self.EAX=int(0)
        self.R=0
        if self.debug:
            print code

    def global_var(self):
        for index,name in enumerate(self.code):
            if name == "GLOBAL_START":
                index+=1
                while(self.code[index]!="GLOBAL_END"):
                    gobal= (self.code[index]).split()
                    self.g_symtable[gobal[0]]=gobal[1]
                    index+=1
                break

    def FIND_IP(self,func):
        for index,name in enumerate(self.code):
            if func in name and self.EIP!=index :
                self.EIP=index
                break

    def FIND_END(self):
        for index,name in enumerate(self.code):
            if name == "MAIN_END":
                self.EIP=index
                break



    def scope(self,temp):
        if temp in self.localstack.keys():
            #print self.localstack[temp]
            return self.localstack[temp]
        elif temp in self.g_symtable.keys():
            #print self.g_symtable[temp]
            return self.g_symtable[temp]
        else:
            print "ERROR"

    def parse(self,ln):
        if self.debug:
         self.print_ln()
        temp=ln.split()
        opcode=temp[0]
        if "START" in temp[0]:
            self.localstack={}
            if len(self.funarg)>0:
                self.localstack[temp[1]]=self.funarg[0]
                del self.funarg[0]
        elif opcode[:3]=="VAR":
            self.localstack[temp[0]]=temp[1]
        elif opcode=="PRINT":
            if temp[1] in self.localstack.keys():
                print self.localstack[temp[1]]
            elif temp[1] in self.g_symtable.keys():
                print self.g_symtable[temp[1]]
            elif "EAX" in temp[1]:
                print(self.EAX)
            else:
                print "ERROR"
        elif opcode =="PUSH":
            if "EAX" in temp[1]:
                self.funarg.append(self.EAX)
            else:
                self.funarg.append(self.scope(temp[1]))
        elif opcode =="CALL":
            self.callstack.append((self.localstack,self.EIP+1))
            self.FIND_IP(temp[1])
            self.EIP-=1
        elif opcode=="CMP":
            var1=0
            var2=0
            if "VAR" in temp[1]:
                var1=int(self.scope(temp[1]))
            else:
                var1=int(temp[1])
            if "VAR" in temp[2]:
                var2=int(self.scope(temp[2]))
            else:
                var2=int(temp[2])
            if var1==var2:
                self.R=0
            elif var1>var2:
                self.R=1
            else:
                self.R=-1
        elif opcode=="JNE":
            if self.R is not 0:
                self.FIND_IP(temp[1])
        elif opcode=="MOV":
            if "VAR" in temp[1]:
                var1=self.scope(temp[1])
                self.EAX=(var1)
            else:
                if "EAX" in temp[1]:
                    if "VAR" in temp[2]:
                        var1=self.scope(temp[2])
                        self.EAX=var1
        elif opcode=="SUB":
            self.EAX=int(self.EAX)
            var1=0
            var2=0
            if "VAR" in temp[1]:
                var1=int(self.scope(temp[1]))
            else:
                if "EAX" in temp[1]:
                    var1=self.EAX
                else:
                    var1=int(temp[1])

            if "VAR" in temp[2]:
                var2=int(self.scope(temp[2]))
            else:
                if "EAX" in temp[2]:
                    var2=self.EAX
                else:
                    var2=int(temp[2])
            self.EAX=var1-var2
        elif opcode=="RET":
            if "VAR" in temp[1]:
                self.EAX=int(self.scope(temp[1]))
            self.stackunwind()
        elif opcode=="MUL":
            self.EAX=int(self.EAX)

            var1=0
            var2=0
            if "VAR" in temp[1]:
                var1=int(self.scope(temp[1]))
            else:
                if "EAX" in temp[1]:
                    var1=self.EAX
                else:
                    var1=int(temp[1])

            if "VAR" in temp[2]:
                var2=int(self.scope(temp[2]))
            else:
                if "EAX" in temp[2]:
                    var2=self.EAX
                else:
                    var2=int(temp[2])
            self.EAX=var1*var2
        elif opcode=="ADD":
            self.EAX=int(self.EAX)
            var1=0
            var2=0
            if "VAR" in temp[1]:
                var1=int(self.scope(temp[1]))
            else:
                if "EAX" in temp[1]:
                    var1=self.EAX
                else:
                    var1=int(temp[1])

            if "VAR" in temp[2]:
                var2=int(self.scope(temp[2]))
            else:
                if "EAX" in temp[2]:
                    var2=self.EAX
                else:
                    var2=int(temp[2])
            self.EAX=var1+var2
        elif opcode=="DIV":
            self.EAX=int(self.EAX)
            var1=0
            var2=0
            if "VAR" in temp[1]:
                var1=int(self.scope(temp[1]))
            else:
                if "EAX" in temp[1]:
                    var1=self.EAX
                else:
                    var1=int(temp[1])

            if "VAR" in temp[2]:
                var2=int(self.scope(temp[2]))
            else:
                if "EAX" in temp[2]:
                    var2=self.EAX
                else:
                    var2=int(temp[2])
            self.EAX=var1/var2

    def stackunwind(self):
        if len(self.callstack) >0:
            self.localstack,self.EIP=self.callstack[-1]
            self.EIP-=1
            del self.callstack[-1]


    def execute(self):
        self.global_var()
        self.FIND_IP("MAIN_START")
        while(self.code[self.EIP]!="MAIN_END"):
            self.parse(self.code[self.EIP])
            self.EIP +=1
        self.parse(self.code[self.EIP])

    def print_ln(self):
        print(self.code[self.EIP]," Line",self.EIP)


def main():
    code=[]
    fin= open("INPUT.assm","r")
    code = fin.read().splitlines()

    In=interp(code)
    In.execute()

if __name__ == '__main__':
    main()