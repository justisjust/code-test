新建本地分支
> git checkout -b 2020

查看分支
> git branch 

将新创建的分支push到远端
> git push origin 2020:2020

拉取远端代码
> git pull origin master

删除远端target文件夹
> git rm -r --cached target 

提交，添加说明
> git commit -m 'commit'

将本次更改push到远端
> git push -u origin master