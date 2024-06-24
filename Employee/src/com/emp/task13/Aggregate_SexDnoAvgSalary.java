package com.emp.task13;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class Aggregate_SexDnoAvgSalary extends Reducer<Text, DoubleWritable,Text,DoubleWritable> {
    public void reduce(Text k, Iterable<DoubleWritable> vlist, Context con) throws IOException, InterruptedException{
        Double sum=0d;
        int n =0;
        for(DoubleWritable v: vlist)
        {
            n++;
           sum+=v.get();
        }
        Double avg = sum/n;
        con.write(k, new DoubleWritable(avg));
    }
}