package pl.mwrobel91.songbook.populator;

public interface Populator<SOURCE, TARGET> {
    void populate(SOURCE source, TARGET target);
}
