## Object.wait()
- current thread returns **lock**, then ```WAITING```
- called when inside synchronized block/ method & currently has the **lock**
- wait until another thread calls ```notify()``` or ```notifyAll()```

## Object.notify()
- wakes up ```WAITING``` thread
- called when inside synchronized block/ method

## Object.notifyAll()

(Object is the parent class of all clases)


------

## Object- wait, notify limits

- notify() awakes random thread in "wait set"
- can't choose either producer thread or consumer thread
- inefficiency - consumer thread might awake another consumer thread when
queue is empty (or vice versa)
- thread **starvation** (producer thread never awaken) (스레드기아현상)
- notifyAll() is also inefficient