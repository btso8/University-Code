#include <stdio.h>
#include <unistd.h>
#include <string.h>

#include "pipeline.hpp"

   PipelineClass Pipe;

int main(int argc, char * argv[])
{   
    int c=0;
    
    printf("-- WEEK34.cpp --/n/n");
    Pipe.StartupMessage();

       if(1)
       {
         Pipe.IssueWidth=1;
         Pipe.ReadPorts=2;
         Pipe.WritePorts=1;
         Pipe.IALUCount=1;
         Pipe.FPALUCount=1;
         Pipe.SHALUCount=1;
         Pipe.CacheMode=0;
       }
       else
       {
         Pipe.IssueWidth=4;
         Pipe.ReadPorts=9;
         Pipe.WritePorts=3;
         Pipe.IALUCount=4;
         Pipe.FPALUCount=1;
         Pipe.SHALUCount=1;
         Pipe.CacheMode=0;
       }
    
        c=Pipe.ReadAssemblerCode(argv[1]);
        if(c<0){ return -1; }
        
        Pipe.DumpCodeList();

        Pipe.InitialSchedule();

        Pipe.DumpPipeline();
        Pipe.PipelineTest();

       // Pipe.DumpPipeline();
       // Pipe.PipelineTest();  
}
