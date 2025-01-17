interface Subject {
    void registerObserver(TaskObserver o);
    void removeObserver(TaskObserver o);
    void notifyObservers();
}