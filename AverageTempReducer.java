package com.sanli.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AverageTempReducer
        extends Reducer<Text, IntWritable, Text, DoubleWritable> {
    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        Double takeAllSum = 0.0;
        Integer Counter = 0;

        for (IntWritable value : values) {
            takeAllSum += value.get();
            Counter++;
        }

        Double averageValue = Double.valueOf((takeAllSum / Counter) / 10);
        context.write(key, new DoubleWritable(meanValue));
    }
}