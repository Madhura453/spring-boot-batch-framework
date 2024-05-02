package com.spring.batch.converter;


public interface Converter<T, E> {
    E convert(T t);
}