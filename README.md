# Map-Reduce-App: Map Reduce Application Implemented using JAVA Program

hdfs dfs -mkdir /mrinputfiles

hdfs dfs -put emp-input-file.csv /mrinputfiles/

1. Employee Department wise Single Grouping Single Aggregations: 

    hadoop jar Employee.jar com.emp.task6.Driver6 /mrinputfiles/emp-input-file.csv /mroutput/task6
    
    hadoop jar Employee.jar com.emp.task7.Driver7 /mrinputfiles/emp-input-file.csv /mroutput/task7
    
    hadoop jar Employee.jar com.emp.task8.Driver8 /mrinputfiles/emp-input-file.csv /mroutput/task8
    
    hadoop jar Employee.jar com.emp.task9.Driver9 /mrinputfiles/emp-input-file.csv /mroutput/task9
    
    hadoop jar Employee.jar com.emp.task10.Driver10 /mrinputfiles/emp-input-file.csv /mroutput/task10

2. Employee Sex wise Single Grouping Single Aggregations:

    hadoop jar Employee.jar com.emp.task1.Driver1 /mrinputfiles/emp-input-file.csv /mroutput/task1
    
    hadoop jar Employee.jar com.emp.task2.Driver2 /mrinputfiles/emp-input-file.csv /mroutput/task2
    
    hadoop jar Employee.jar com.emp.task3.Driver3 /mrinputfiles/emp-input-file.csv /mroutput/task3
    
    hadoop jar Employee.jar com.emp.task4.Driver4 /mrinputfiles/emp-input-file.csv /mroutput/task4
    
    hadoop jar Employee.jar com.emp.task5.Driver5 /mrinputfiles/emp-input-file.csv /mroutput/task5

3. Employee Sex wise Single Grouping Multiplie Aggregations:

    hadoop jar Employee.jar com.emp.task16.Driver16 /mrinputfiles/emp-input-file.csv /mroutput/task16

4. Employee Department wise Single Grouping Multiple Aggregations:

    hadoop jar Employee.jar com.emp.task17.Driver17 /mrinputfiles/emp-input-file.csv /mroutput/task17

5. Multi Grouping Single Aggregations:

    hadoop jar Employee.jar com.emp.task11.Driver11 /mrinputfiles/emp-input-file.csv /mroutput/task11
    
    hadoop jar Employee.jar com.emp.task12.Driver12 /mrinputfiles/emp-input-file.csv /mroutput/task12
    
    hadoop jar Employee.jar com.emp.task13.Driver13 /mrinputfiles/emp-input-file.csv /mroutput/task13
    
    hadoop jar Employee.jar com.emp.task14.Driver14 /mrinputfiles/emp-input-file.csv /mroutput/task14
    
    hadoop jar Employee.jar com.emp.task15.Driver15 /mrinputfiles/emp-input-file.csv /mroutput/task15

6. Multi Grouping Multiple Aggregations:

    hadoop jar Employee.jar com.emp.task18.Driver18 /mrinputfiles/emp-input-file.csv /mroutput/task18
   Sreyas Institute 
