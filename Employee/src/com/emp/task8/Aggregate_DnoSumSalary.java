package com.emp.task8;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class Aggregate_DnoSumSalary extends Reducer<Text, DoubleWritable,Text,DoubleWritable> {
    public void reduce(Text k, Iterable<DoubleWritable> vlist, Context con) throws IOException, InterruptedException{
        Double sum=0d;
        for(DoubleWritable v: vlist){
            sum+=v.get();
        }
        con.write(k, new DoubleWritable(sum));
    }
}