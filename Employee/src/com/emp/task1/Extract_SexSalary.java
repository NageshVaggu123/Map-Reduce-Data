package com.emp.task1;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class Extract_SexSalary extends Mapper<LongWritable, Text,Text, DoubleWritable> {
    /*

    file location : "hdfs://localhost:9000/emp.txt"

    schema : Emp_Id, Emp_Name, Emp_Sex, Emp_Salary, Emp_DepartmentNo

    delimiter : "," (comma)

    sample row : 001, A, m, 20,10000.00, 111

    index values: 0   1  2   3    4       5

    Key: Emp_Sex as Key
    Value: Emp_Salary

    Goal: SELECT sex,MAX(sal) FROM emp GROUP BY sex;

    Type Casting: Extract Specific Fields(sex,sal) by Indexing values and Type Cast sex as String & salary as Double

    */
    public void map(LongWritable k, Text v, Mapper.Context con) throws IOException, InterruptedException {
            /*
            1. Parameter takes k->Key as Offset Value of Line in a File
            2. Parameter takes v->Value as Entire Line in a File
             */
        // v is Line in the form of Text Format converting to String type.
        // if 100 lines 100 conversion happening
        String line = v.toString();
        // Breaking the Line in to words based on delimiter comma(,)
        // after successfully splitting the line it return array of words
        String[] w = line.split(",");
        // from array of words by using index value extracting specific sex, sal
        String sex = w[2];
        // here salary is extracted but it is in the form of string so type casting to Double Type
        Double sal = Double.parseDouble(w[4]);
        // Finally the mapper output is given to reducer phase.
        // example: m 10000.00
        con.write(new Text(sex), new DoubleWritable(sal));
    }
}