#### Primary Locker Robot

##### 用户存包

* 柜子没满，robot帮用户存包，用户可以得到一个票据
  * given a robot who manages two empty lockers(capacity: 1) when save a bag then user would get a ticket and the bag would be saved in locker 1
  * given a robot who manages one full locker(capacity: 1, locker 1) and a empty locker(capacity: 1, locker 2) when save a bag then user would get a ticket and the bag would be saved in locker 2
  * given a robot who manages two empty lockers(capacity: 1) when save two bags then user would get two different tickets and the bags would be saved in order.
* 柜子满了，robot帮用户存包，用户不能存包而且会得到错误提示
  * given a robot who manages two full lockers(capacity: 1) when save a bag the user would get an error message.



##### 用户取包

* given a valid ticket when retrieves bag then user would get the bag.
* given an invalid ticket when retrieves bag then user would get error message('票据无效').
* given an used ticket when retrieves bag then user would get error message('票据无效').



##### 其他

* given a robot who manages one full locker(capacity: 1, locker 1) and a empty locker(capacity: 1, locker 2) when retrieve the bag in locker 1 and save a bag then user would get a ticket and the bag would be saved in locker 1