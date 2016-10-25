<%--
  Created by IntelliJ IDEA.
  User: 95
  Date: 2016/10/23
  Time: 22:10
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
            <h4 class="blue bigger">修改部门</h4>
        </div>

        <div class="modal-body overflow-visible">
            <div class="row">
                <form action="department_update" method="post" id="editForm">
                    <s:hidden name="did" value="%{model.did}"/>
                    <div class="col-xs-12 col-sm-10 col-sm-offset-2">
                        <div class="form-group">
                            <label>部门名称</label>
                            <div>
                                <s:textfield name="dname" value="%{model.dname}"/>
                            </div>
                        </div>

                        <div class="space-4"></div>

                        <div class="form-group">
                            <label>部门描述</label>
                            <div>
                                <s:textarea name="ddesc" value="%{model.ddesc}"/>
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