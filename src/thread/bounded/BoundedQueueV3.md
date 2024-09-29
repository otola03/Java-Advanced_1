## Object.wait()
- current thread returns **lock**, then ```WAITING```
- called when inside synchronized block/ method & currently has the **lock**
- wait until another thread calls ```notify()``` or ```notifyAll()```

## Object.notify()
- wakes up ```WAITING``` thread
- called when inside synchronized block/ method

## Object.notifyAll()

(Object is the parent class of all clases)