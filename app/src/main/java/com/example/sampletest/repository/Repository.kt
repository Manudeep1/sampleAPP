package com.example.sampletest.repository

import com.example.sampletest.api_interface.SampleApi


class Repository constructor(private val sampleApi: SampleApi) {
    fun getPost() = sampleApi.getData()
}