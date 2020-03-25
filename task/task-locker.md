### Tasking

#### 用户存包

* 柜子没满，用户可以存包，成功后会收到票据
  * given an empty locker when save a bag then user would get a ticket
  * given a locker with one empty room when save a bag then user would get a ticket
  * given a locker with one empty room when save nothing then user would get a ticket  
* 柜子满了，用户不能存包，没有票据但会得到错误提示
  * given a full locker when save a bag then user would get error message ('柜子已满')



#### 用户取包

* 用户根据票据可以成功取包
  * given a valid ticket when retrieve bag then user would get the bag.
  * given an invalid ticket when retrieve bag then user would get error message('票据无效').
  * given an used ticket when retrieve bag then user would get error message('票据无效').
