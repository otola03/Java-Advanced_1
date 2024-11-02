# Problem: Thread-1 and Thread-2 both acquires lock

## 1. Check lock usage
## 2. Change lock value
these two parts are not atomic.
---
`Thread-1`: `if(!lock)` -> `lock` is false -> pass

`Thread-2`: `if(!lock)` -> `lock` is false -> pass

`Thread-1`: `lock = true` code -> lock: `false` -> `true`

`Thread-2`" `lock = true` code -> lock: `true` -> `true`

=> `Thread-1` and `Thread-2` both acquires lock and do their job.

### Needs to make safe critical section with `synchronized` or `Lock`
### Or, use `CAS operation` and bind that two steps into one.
