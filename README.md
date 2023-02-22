# AverageTempWithHadoop

Find average temp with hadoop

## İçindekiler

- [AverageTempWithHadoop](#averagetempwithhadoop)
  - [İçindekiler](#i̇çindekiler)
  - [İşlem Adımları](#i̇şlem-adımları)
    - [WordCount Project](#wordcount-project)
    - [AverageTempurature Project](#averagetempurature-project)
  - [Referanslar](#referanslar)

## İşlem Adımları

İlk olarak hadoop docker ortamında ayağa kaldırılmalıdır. Bunun için önce docker programı ayağa kaldırılmalı ve daha sonra hadoop programı çalıştırılmalıdır.

### WordCount Project

```c
docker-compose up --d
```

```c
docker ps // Show active images
```

```c
docker cp ~/Documents/fake.cvs namenode:fake.cvs // Copy data file from local to inside namenode
```

```c
hdfs dfs -ls /user/root/input // Show the data file in namenode 
```

```c
docker exec —tty —interactive namenode bash // Start namenode
```

```c
hdfs dfs -put ./input/ * input // Put the file from namenode to hdfs and completed file operation
```

Bu noktada probleme uygun olarak bir java kodu yazıldığı unutulmamalıdır.

```c
hadoop jar hadoop-mapreduce-examples-2.7.1-sources.jar org.apache.hadoop.examples.WordCount input output 
// Using jar file with project name (org.apache.hadoop.examples.WordCount)
// Give a input file for data
// Give a output file for output values
```

```c
hdfs dfs -cat /user/root/output/part-r-00000 // Print the result 
// Output file path may differ
```

### AverageTempurature Project

Yıllara göre ortalama sıcaklık hesabında da benzer işlem adımları uygulanacaktır. En önemli farklılık geliştirme yapılacak olan java kodlarındadır. İlgili java kodu yazıldıktan sonra program hadoop ortamında çalıştırılacaktır.

## Referanslar

* [WordCount Jar File](https://repo1.maven.org/maven2/org/apache/hadoop/hadoop-mapreduce-examples/2.7.1/)
* [Sample Project](https://github.com/suraj-dev/AverageTemperature-Hadoop-MapReduce)
* [Map-Reduce Tutorial](https://hadoop.apache.org/docs/stable/hadoop-mapreduce-client/hadoop-mapreduce-client-core/MapReduceTutorial.html#Source_Code)


 


