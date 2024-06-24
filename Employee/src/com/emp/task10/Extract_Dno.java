package com.emp.task10;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class Extract_Dno extends Mapper<LongWritable, Text,Text, IntWritable> {
    /*

    file : "hdfs://localhost:9000/emp.txt"
    schema : Emp_Id, Emp_Name, Emp_Sex, Emp_Salary, Emp_DepartmentNo
    delimiter : "," (comma)
    sample row : 001, A, m, 20,10000.00, 111
    index values: 0   1  2   3    4       5
    Emp_Sex as Key, Emp_Salary as Value.
    Goal: is to extract the Employee Sex and Employee Salary
    Type Casting: sex as String & salary as Double

    */
    public void map(LongWritable k, Text v, Context con) throws IOException, InterruptedException {
            /*
            1. Parameter takes k->Key as Offset Value of Line in a File
            2. Parameter takes v->Value as Entire Line in a File
             */

        String line = v.toString();
        String[] w = line.split(",");
        String dno = w[5];
        int one = 1;
        con.write(new Text(dno), new IntWritable(one));
    }
}
