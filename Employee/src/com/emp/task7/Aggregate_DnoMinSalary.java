package com.emp.task7;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class Aggregate_DnoMinSalary extends Reducer<Text, DoubleWritable,Text,DoubleWritable> {
    public void reduce(Text k, Iterable<DoubleWritable> vlist, Context con) throws IOException, InterruptedException{
        Double minimum=0d;
        int n =0;
        for(DoubleWritable v: vlist)
        {
            n++;
            if(n==1){
                minimum=v.get();
            }
            minimum = Math.min(minimum, v.get());
        }
        con.write(k, new DoubleWritable(minimum));
    }
}