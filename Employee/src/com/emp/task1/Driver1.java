package com.emp.task1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Driver1 {
    public static void main(String[] args) throws Exception
    {
        //creating configuration class object.
        Configuration conf = new Configuration();
        //creating Job class object with new configuration and job name.
        Job j = new Job(conf,"emp_task1");

        //setting Driver, Mapper, Reducer classes and output key and output value data types.
        j.setJarByClass(Driver1.class);
        j.setMapperClass(Extract_SexSalary.class);
        j.setReducerClass(Aggregate_SexMaxSalary.class);
        j.setOutputKeyClass(Text.class);
        j.setOutputValueClass(DoubleWritable.class);

        //Input File Location Argument is taken while submitting the jar file  to hadoop cluster.
        Path p1 = new Path(args[0]);
        //output File Location Argument is given while submitting the jar file to hadoop cluster.
        Path p2 = new Path(args[1]);

        //The Path of the Input File is added to Job.
        FileInputFormat.addInputPath(j,p1);
        //The Path of the Output File is added to Job.
        FileOutputFormat.setOutputPath(j, p2);

        //After Successfull completion return 0 else 1 abnormally stopping the entire map-reduce job.
        System.exit(j.waitForCompletion(true) ? 0:1);
    }
}
