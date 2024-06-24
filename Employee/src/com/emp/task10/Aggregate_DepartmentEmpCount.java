package com.emp.task10;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class Aggregate_DepartmentEmpCount extends Reducer<Text, IntWritable,Text,IntWritable> {
    public void reduce(Text k, Iterable<IntWritable> vlist, Context con) throws IOException, InterruptedException{
        int count=0;
        for(IntWritable v: vlist)
        {
            count+=v.get();
        }
        con.write(k, new IntWritable(count));
    }
}