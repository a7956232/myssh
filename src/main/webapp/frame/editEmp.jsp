<%--
  Created by IntelliJ IDEA.
  User: 95
  Date: 2016/10/13
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head></head>
<body>
<table border="0" width="600px">
    <tr>
        <td align="center" style="font-size:24px; color:#666"> 员工编辑</td>
    </tr>
    <tr>
        <td align="right" >
            <a href="javascript:document.getElementById('editForm').submit()">保存</a> &nbsp;&nbsp;
            <a href="javascript:history.go(-1)">退回</a>
        </td>
    </tr>
</table>
<br/>

<s:form id="editForm" action="employee_update" method="POST" namespace="/" theme="simple">
    <s:hidden name="eid" value="%{model.eid}"/>
    <table border='0' cellpadding="0"  cellspacing="10">

        <tr>
            <td>姓名：</td>
            <td><s:textfield name="ename" value="%{model.ename}"/></td>
            <td>性别：</td>
            <td><s:radio list="{'男','女'}" name="sex" value="%{model.sex}"/></td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td><s:textfield name="username" value="%{model.username}"/></td>
            <td>密码：</td>
            <td><s:password name="password" value="%{model.password}"/></td>
        </tr>
        <tr>
            <td>出生日期：</td>
            <td><input type="text" name="birthday" value="<s:date name="model.birthday" format="yyyy-MM-dd"/>"/></td>
            <td>入职时间：</td>
            <td><input type="text" name="joinDate" value="<s:date name="model.joinDate" format="yyyy-MM-dd"/>"/></td>
        </tr>

        <tr>
            <td>所属部门：</td>
            <td><s:select name="department.did" list="list" value="%{model.department.did}" listKey="did" listValue="dname" headerKey="" headerValue="--请选择--"/></td>
            <td>编号：</td>
            <td><s:textfield name="eno" value="%{model.eno}"/></td>
        </tr>
    </table>
</s:form>

</body>
</html>