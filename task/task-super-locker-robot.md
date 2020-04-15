#### Super Locker Robot

##### 用户存包

- 柜子没满，robot帮用户存包，用户可以得到一个票据
  * 剩余容量相同
    * given a robot which manages two empty lockers(capacity: 1) when user saves a bag then the user would get a ticket and then the bag would be saved in locker 1
  * 剩余容量不同
    * given a robot which manages two lockers(locker 1 capacity: 2 saved 1, locker 2 capacity: 1) when user saves a bag then the user would get a ticket and then the bag would be saved in locker 2
- 柜子满了，robot帮用户存包，用户不能存包而且会得到错误提示
  * given a robot which manages two full lockers(capacity: 1) when user saves a bag then the user would get an error message('柜子已满')



##### 用户取包

- given a valid ticket when retrieves bag then user would get the bag.
- given an invalid ticket when retrieves bag then user would get error message('票据无效').
- given an used ticket when retrieves bag then user would get error message('票据无效').