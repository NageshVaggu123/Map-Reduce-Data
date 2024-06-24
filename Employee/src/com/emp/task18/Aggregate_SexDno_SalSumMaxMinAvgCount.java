package com.emp.task18;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class Aggregate_SexDno_SalSumMaxMinAvgCount extends Reducer<Text, DoubleWritable, Text, Text> {

    public void reduce(Text k, Iterable<DoubleWritable> vlist, Context con) throws IOException, InterruptedException{
        Double maximum=0d;
        Double minimum=0d;
        Double sum=0d;

        int n =0;
        for(DoubleWritable v: vlist)
        {
            n++;
            if(n==1){
                maximum=v.get();
                minimum = v.get();
            }
            maximum = Math.max(maximum, v.get());
            minimum = Math.min(minimum, v.get());
            sum =sum+v.get();
        }
        Double avg = sum/n;

        String s = maximum+", "+minimum+", "+sum+", "+avg+", "+n;

        con.write(k, new Text(s));
    }
}