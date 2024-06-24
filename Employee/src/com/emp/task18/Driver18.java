package com.emp.task18;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Driver18 {
    public static void main(String[] args) throws Exception
    {
        Configuration conf = new Configuration();
        Job j = new Job(conf,"emp_task18");
        j.setJarByClass(Driver18.class);
        j.setMapperClass(Extract_SexDnoSalary.class);
        j.setReducerClass(Aggregate_SexDno_SalSumMaxMinAvgCount.class);
        j.setOutputKeyClass(Text.class);
        j.setOutputValueClass(DoubleWritable.class);
        Path p1 = new Path(args[0]); //input
        Path p2 = new Path(args[1]); //output

        FileInputFormat.addInputPath(j,p1);
        FileOutputFormat.setOutputPath(j, p2);

        System.exit(j.waitForCompletion(true) ? 0:1);
    }
}
