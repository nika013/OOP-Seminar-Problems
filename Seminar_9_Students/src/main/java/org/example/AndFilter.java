package org.example;

import java.util.ArrayList;
import java.util.List;

public class AndFilter implements Filter {
    private List<Filter> filters;
    public AndFilter() {
        filters = new ArrayList<>();
    }

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    @Override
    public boolean contains(Student s) {
        for (Filter filter : filters) {
            if (!filter.contains(s)) {
                return false;
            }
        }
        return true;
    }

}
