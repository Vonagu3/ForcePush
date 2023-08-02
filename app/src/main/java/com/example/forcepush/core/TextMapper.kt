package com.example.forcepush.core

interface TextMapper<T> : Abstract.Mapper.Data<String, T> {
    interface Void : TextMapper<Unit>
}