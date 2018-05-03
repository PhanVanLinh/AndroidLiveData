# AndroidLiveData
> LiveData is an observable data holder class

    LiveData<Integer> score

When we change score value, any client observe score will receive a change. It will
look like Observer pattern. 

### Different between LiveData and REGULAR Observable
> LiveData is lifecycle-aware, meaning it respects the lifecycle of 
other app components, such as activities, fragments, or services

=> `LiveData` **AUTOMATICALLY work well** with android life cycle.  
Example  
When activity is destroyed we don't need to remove the observe = no memory leak.  
When rotate activity, it immediately receives the latest available data

https://developer.android.com/topic/libraries/architecture/livedata#the_advantages_of_using_livedata

### MutableLiveData vs LiveData

`MutableLiveData` extends `LiveData` and it have more 2 functions setValue and postValue

### RxJava vs LiveData
- `LiveData` have life cycle aware and `RXJava` have not
- `RXJava` help us work in multiple thread. `LiveData` only work in main thread 
- Currently, I see `RXJava` support many feature than `LiveData`, RXJava support many 
feature like switch thread, execute many observers, handling error, ....

### Example of LiveData

We can use LiveData in MVVM model, or Architect Component Model.  
`LiveData` is used for observe data change from `ViewModel` than we will update the `View` (Activity, Fragment, ...) data

### Reference
- https://developer.android.com/topic/libraries/architecture/livedata