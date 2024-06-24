package com.emp.task1;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class Aggregate_SexMaxSalary extends Reducer<Text, DoubleWritable,Text,DoubleWritable> {
    //Reducer Phase by defaults runs Sort and Shuffle Phases.
    //Reducer Phase takes the input in the form key,values pairs and gives outut as key,value pairs.
    public void reduce(Text k, Iterable<DoubleWritable> vlist, Context con) throws IOException, InterruptedException{
        //key as Text format, example: m
        //List of values as DoubleWritable format, example: <10000.00, 10010.00, 15001.00, 33009.00, 12000.00, 100000.00, 15000.99, 80000.00, 70999.88, 77000.00, 38000.00, 25000.00>
        //for aggregation we have to write the logic as below
        Double maximumSalary=0d;
        int n =0;
        for(DoubleWritable v: vlist)
        {
            n++;
            if(n==1){
                // taking first element in the list of salary values.
                maximumSalary=v.get();
            }
            // at each time comparing first element with first element in the list of salary values.
            // if the salary is max
            maximumSalary = Math.max(maximumSalary, v.get());
        }
        /*
        finally the output is stored in the specified hdfs directory.
        f 122000.88
        m 100000.00
        */
        con.write(k, new DoubleWritable(maximumSalary));
    }
}