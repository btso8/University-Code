#include <stdio.h>
#include <unistd.h>
#include <string.h>

#include "pipeline.hpp"

   void FixWeek2Example();

   PipelineClass Pipe;

int main(int argc, char * argv[])
{   
    int c=0;
    
    printf("-- WEEK2.cpp --/n/n");
    Pipe.StartupMessage();

        Pipe.ReadPorts=3;
        Pipe.WritePorts=1;
        Pipe.IssueWidth=1;
        Pipe.IALUCount=2;
        Pipe.FPALUCount=2;
        Pipe.SHALUCount=2;
        Pipe.CacheMode=0;

        c=Pipe.ReadAssemblerCode(argv[1]);
        if(c<0){ return -1; }
        
        Pipe.DumpCodeList();

        Pipe.InitialSchedule();
        Pipe.DumpPipeline();
        Pipe.PipelineTest();

        //FixWeek2Example();

        //Pipe.DumpPipeline();
        //Pipe.PipelineTest();  
}

void FixWeek2Example()
{
    Pipe.InsertStall(1,3);
    Pipe.InsertStall(1,3);
    
    Pipe.InsertStall(5,7);
    Pipe.InsertStall(5,7);
    Pipe.InsertStall(5,7);
    
    Pipe.InsertStall(4,9);
}
