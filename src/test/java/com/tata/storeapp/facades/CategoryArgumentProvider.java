package com.tata.storeapp.facades;

import com.tata.storeapp.models.Category;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CategoryArgumentProvider implements ArgumentsProvider {


    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        Category category=null;
        List<Category> categoryList=new ArrayList<Category>();
        for(int i=0;i<10;i++){

            category=new Category();
            category.setName("cat"+i);
            categoryList.add(category);
        }

        return categoryList.stream().map(Arguments::of);
    }
}
