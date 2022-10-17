package converter;

import pl.mwrobel91.songbook.populator.Populator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Converter<SOURCE, TARGET> {

    private Class<TARGET> targetClass;
    private List<Populator> populators = new ArrayList<>();

    public Converter(Class<TARGET> targetClass) {
        this.targetClass = targetClass;
    }

    public static <SOURCE, TARGET> Converter<SOURCE,TARGET> of (Class<TARGET> targetClass) {
        return new Converter<SOURCE, TARGET>(targetClass);
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

    public <SOURCE, TARGET> Converter<SOURCE, TARGET> withPopulator(Populator<SOURCE, TARGET> populator) {
        if (Objects.nonNull(populator)) {
            populators.add(populator);
        }
        return (Converter<SOURCE, TARGET>) this;
    }
}
