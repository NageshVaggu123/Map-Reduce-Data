package com.emp.task6;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class Aggregate_DnoMaxSalary extends Reducer<Text, DoubleWritable,Text,DoubleWritable> {
    public void reduce(Text k, Iterable<DoubleWritable> vlist, Context con) throws IOException, InterruptedException{
        Double maximum=0d;
        int n =0;
        for(DoubleWritable v: vlist)
        {
            n++;
            if(n==1){
                maximum=v.get();
            }
            maximum = Math.max(maximum, v.get());
        }
        con.write(k, new DoubleWritable(maximum));
    }
}