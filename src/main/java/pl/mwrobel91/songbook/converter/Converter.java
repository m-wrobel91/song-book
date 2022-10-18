package pl.mwrobel91.songbook.converter;

import org.apache.commons.lang3.ArrayUtils;
import pl.mwrobel91.songbook.populator.Populator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Converter<SOURCE, TARGET> {

    private final Class<TARGET> targetClass;
    private final List<Populator> populators = new ArrayList<>();

    public Converter(Class<TARGET> targetClass, Populator<SOURCE, TARGET>... populators) {
        this.targetClass = targetClass;
        if (ArrayUtils.isNotEmpty(populators)) {
            for (Populator<SOURCE, TARGET> populator : populators) {
                addPopulator(populator);
            }
        }
    }

    public TARGET convert(SOURCE source) {
        TARGET target = createFromClass();
        for (Populator populator : this.populators) {
            populator.populate(source, target);
        }
        return target;
    }

    public List<TARGET> convertAll(List<SOURCE> objectsToBeConverted) {
        List<TARGET> convertedList = new ArrayList<>();
        for (SOURCE objectToBeConverted : objectsToBeConverted) {
            convertedList.add(convert(objectToBeConverted));
        }
        return convertedList;
    }

    private TARGET createFromClass() {
        try {
            return targetClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addPopulator(Populator<SOURCE, TARGET> populator) {
        if (Objects.nonNull(populator)) {
            populators.add(populator);
        }
    }
}
