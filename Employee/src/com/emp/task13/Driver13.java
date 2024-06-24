package com.emp.task13;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Driver13 {
    public static void main(String[] args) throws Exception
    {
        Configuration conf = new Configuration();
        Job j = new Job(conf,"emp_task13");
        j.setJarByClass(Driver13.class);
        j.setMapperClass(Extract_SexSalary.class);
        j.setReducerClass(Aggregate_SexDnoAvgSalary.class);
        j.setOutputKeyClass(Text.class);
        j.setOutputValueClass(DoubleWritable.class);
        Path p1 = new Path(args[0]); //input
        Path p2 = new Path(args[1]); //output

        FileInputFormat.addInputPath(j,p1);
        FileOutputFormat.setOutputPath(j, p2);

        System.exit(j.waitForCompletion(true) ? 0:1);
    }
}
