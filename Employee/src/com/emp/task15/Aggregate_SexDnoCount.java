package com.emp.task15;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class Aggregate_SexDnoCount extends Reducer<Text, IntWritable,Text,IntWritable> {
    public void reduce(Text k, Iterable<IntWritable> vlist, Context con) throws IOException, InterruptedException{
        int count =0;
        for(IntWritable v: vlist)
        {
            count+=1;
        }
        con.write(k, new IntWritable(count));
    }
}