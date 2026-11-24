package xyz.refinedev.spigot.feature.async.profiler;

public interface AsyncProfiler {
    public void onTaskStart();
    public void onTaskStop();
}
