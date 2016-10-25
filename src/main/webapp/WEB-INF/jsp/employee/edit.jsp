
<%--
  Created by IntelliJ IDEA.
  User: 95
  Date: 2016/10/23
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<div class="modal-dialog">

    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="blue bigger">修改员工</h4>
        </div>

        <div class="modal-body overflow-visible">
            <div class="row">
                <form action="employee_update" method="post" id="editForm">
                    <s:hidden name="eid" value="%{model.eid}"/>
                    <div class="col-xs-12 col-sm-10 col-sm-offset-2">
                        <div class="form-group">
                            <label>所属部门</label>
                            <div>
                                <s:select name="department.did" list="list" value="%{model.department.did}" listKey="did" listValue="dname" headerKey="" headerValue="--请选择--" />
                            </div>
                        </div>

                        <div class="space-4"></div>

                        <div class="form-group">
                            <label>姓名</label>
                            <div>
                                <s:textfield name="ename" value="%{model.ename}"/>
                            </div>
                        </div>

                        <div class="space-4"></div>

                        <div class="form-group">
                            <label>性别</label>

                            <div>
                                <s:radio name="sex" list="{'男','女'}" value="%{model.sex}"/>
                            </div>
                        </div>

                        <div class="space-4"></div>

                        <div class="form-group">
                            <label>编号</label>
                            <div>
                                <s:textfield name="eno" value="%{model.eno}"/>
                            </div>
                        </div>

                        <div class="space-4"></div>

                        <div class="form-group">
                            <label>出生日期</label>
                            <div>
                                <input type="text" name="birthday" value="<s:date name="model.birthday" format="yyyy-MM-dd"/>"/>
                            </div>
                        </div>

                        <div class="space-4"></div>

                        <div class="form-group">
                            <label>入职时间</label>

                            <div>
                                <input type="text" name="joinDate" value="<s:date name="model.joinDate" format="yyyy-MM-dd"/>"/>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div class="modal-footer">
            <button class="btn btn-sm" data-dismiss="modal">
                <i class="icon-remove"></i>
                取消
            </button>

            <a type="button" class="btn btn-sm btn-primary" href="javascript:document.getElementById('editForm').submit()">
                <i class="icon-ok"></i>
                保存
            </a>
        </div>
    </div>
</div>
</body>
</html>
