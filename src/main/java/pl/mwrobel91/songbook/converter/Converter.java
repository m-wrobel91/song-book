package pl.mwrobel91.songbook.converter;

import org.apache.commons.lang3.ArrayUtils;
import pl.mwrobel91.songbook.populator.Populator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Converter<SOURCE, TARGET> {

    private final Class<TARGET> targetClass;
    private final List<Populator> populators = new ArrayList<>();

    public Converter(final Class<TARGET> targetClass, final Populator<SOURCE, TARGET>... populators) {
        this.targetClass = targetClass;
        if (ArrayUtils.isNotEmpty(populators)) {
            for (final Populator<SOURCE, TARGET> populator : populators) {
                addPopulator(populator);
            }
        }
    }

    public TARGET convert(final SOURCE source) {
        final TARGET target = createFromClass();
        for (final Populator populator : this.populators) {
            populator.populate(source, target);
        }
        return target;
    }

    public List<TARGET> convertAll(final List<SOURCE> objectsToBeConverted) {
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

    public void addPopulator(final Populator<SOURCE, TARGET> populator) {
        if (Objects.nonNull(populator)) {
            populators.add(populator);
        }
    }
}
