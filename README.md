OpenPlayInfo
============

trhift,mybatis,mutiService

该工程中funBase是基础工程，其他项目以来于此。

1：rpc服务使用thrift实现，并且支持多rpc服务共享一个端口
2：数据持久层采用mybaits实现。
3：数据全部加载与内从中，通过定时机制同步更新内存。
4：数据服务，支持读写分离，但是需要自己手动设定。