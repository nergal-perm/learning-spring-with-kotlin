package org.springframework.beans.factory

import org.springframework.beans.factory.stereotype.Component
import java.io.File

class BeanFactory {
    var singletons = HashMap<String, Any>()

    fun getBean(beanName: String): Any? {
        return singletons[beanName]
    }

    fun instantiate(basePackage: String) {
        val classLoader = ClassLoader.getSystemClassLoader()
        val path: String = basePackage.replace(".", "/")
        val resources = classLoader.getResources(path).toList()

        resources.forEach {
            val file = File(it.toURI())
            file.listFiles().filter {
                it.name.endsWith(".class")
            }.map {
                val className = it.name.substring(0, it.name.lastIndexOf("."))
                Class.forName("$basePackage.$className")
            }.filter {
                it.isAnnotationPresent(Component::class.java)
            }.forEach {
                val instance = it.newInstance()
                val className = it.name.substring(it.name.lastIndexOf(".") + 1)
                val beanName = className.substring(0,1).toLowerCase() + className.substring(1)
                singletons[beanName] = instance
            }
        }
        println(singletons.keys)
    }

}

