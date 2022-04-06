<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="访客id" prop="visitorId">
        <el-input
          v-model="queryParams.visitorId"
          placeholder="请输入访客id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="访客姓名" prop="visitName">
        <el-input
          v-model="queryParams.visitName"
          placeholder="请输入访客姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="访客电话" prop="visitorTelephone">
        <el-input
          v-model="queryParams.visitorTelephone"
          placeholder="请输入访客电话"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="紧急联系人姓名" prop="emergencyContactName">
        <el-input
          v-model="queryParams.emergencyContactName"
          placeholder="请输入紧急联系人姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="紧急联系人电话" prop="emergencyContactTelephone">
        <el-input
          v-model="queryParams.emergencyContactTelephone"
          placeholder="请输入紧急联系人电话"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="访问权限" prop="limitsOfAuthority">
        <el-input
          v-model="queryParams.limitsOfAuthority"
          placeholder="请输入访问权限"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:visitor:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:visitor:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:visitor:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:visitor:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="visitorList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="访客id" align="center" prop="visitorId" />
      <el-table-column label="访客姓名" align="center" prop="visitName" />
      <el-table-column label="访客电话" align="center" prop="visitorTelephone" />
      <el-table-column label="紧急联系人姓名" align="center" prop="emergencyContactName" />
      <el-table-column label="紧急联系人电话" align="center" prop="emergencyContactTelephone" />
      <el-table-column label="访问权限" align="center" prop="limitsOfAuthority" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:visitor:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:visitor:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改访客用户信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="访客姓名" prop="visitName">
          <el-input v-model="form.visitName" placeholder="请输入访客姓名" />
        </el-form-item>
        <el-form-item label="访客电话" prop="visitorTelephone">
          <el-input v-model="form.visitorTelephone" placeholder="请输入访客电话" />
        </el-form-item>
        <el-form-item label="紧急联系人姓名" prop="emergencyContactName">
          <el-input v-model="form.emergencyContactName" placeholder="请输入紧急联系人姓名" />
        </el-form-item>
        <el-form-item label="紧急联系人电话" prop="emergencyContactTelephone">
          <el-input v-model="form.emergencyContactTelephone" placeholder="请输入紧急联系人电话" />
        </el-form-item>
        <el-form-item label="访问权限" prop="limitsOfAuthority">
          <el-input v-model="form.limitsOfAuthority" placeholder="请输入访问权限" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listVisitor, getVisitor, delVisitor, addVisitor, updateVisitor } from "@/api/system/visitor";

export default {
  name: "Visitor",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 访客用户信息表格数据
      visitorList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        visitorId: null,
        visitName: null,
        visitorTelephone: null,
        emergencyContactName: null,
        emergencyContactTelephone: null,
        limitsOfAuthority: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        visitName: [
          { required: true, message: "访客姓名不能为空", trigger: "blur" }
        ],
        visitorTelephone: [
          { required: true, message: "访客电话不能为空", trigger: "blur" }
        ],
        emergencyContactName: [
          { required: true, message: "紧急联系人姓名不能为空", trigger: "blur" }
        ],
        emergencyContactTelephone: [
          { required: true, message: "紧急联系人电话不能为空", trigger: "blur" }
        ],
        limitsOfAuthority: [
          { required: true, message: "访问权限不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询访客用户信息列表 */
    getList() {
      this.loading = true;
      listVisitor(this.queryParams).then(response => {
        this.visitorList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        visitorId: null,
        visitName: null,
        visitorTelephone: null,
        emergencyContactName: null,
        emergencyContactTelephone: null,
        limitsOfAuthority: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.visitorId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加访客用户信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const visitorId = row.visitorId || this.ids
      getVisitor(visitorId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改访客用户信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.visitorId != null) {
            updateVisitor(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addVisitor(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const visitorIds = row.visitorId || this.ids;
      this.$modal.confirm('是否确认删除访客用户信息编号为"' + visitorIds + '"的数据项？').then(function() {
        return delVisitor(visitorIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/visitor/export', {
        ...this.queryParams
      }, `visitor_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
