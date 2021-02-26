# Architecture 

GoodHabits app is based on 3 tier architechture 
* Presentation Layer 
* Logic Layer
* Persistense Layer

### Visualization 
![Architecture]()




### Description 
#### **Presentation Layer**
Presentation Layer consists of all the user interaction files 
```
AddActivity 
    Helps to create a new Habit and add it to the list of existing Habits. 
```
```
AllHabitsActivity 
    List view containing all existing Habits.
```
```
MainActivity
    The file for the view for the starting screen of the app.
```
```
ProfileActivity
    Display the profile details of the user.
```
```
ProfileInputActivity
    Helps the user to create profile.
```
```
SettingsActivity
    Helps user to manage the settings related to App.
```
 


#### **Logic Layer**
Logic layer consists of Time picker file
```
TimeParser
    Helps to display the time in 12-hour format.
```
```
TimePickerFragment
    Widget for picking the time.
```

### **Persistence Layer**
We have database interface and database implementation in Persistence Layer

**Database Interface** 
```
HabitStorageManager
    Interface for HabitStorage.
```
```
ProfileStorageManager
    Interface for ProfileStorage.
```


**Database Implementation**
```
HabitStorage
    Storage for all the Habit objects.
```
```
ProfileStorage
    Storage for the Profile object.
```


#### **Objects**
**Domain Objets**
```
Habit
    Habit object.
```
```
Profile
    Profile object.
```
