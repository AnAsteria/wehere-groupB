<template>
  <div class="calendar_box">
    <el-row :gutter="20">
      <el-col :span="18">
        <full-calendar ref="fullCalendar" style="height: 100%" :options="calendarOptions"></full-calendar>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import FullCalendar from "@fullcalendar/vue";
import dayGridPlugin from "@fullcalendar/daygrid";
import interactionPlugin from "@fullcalendar/interaction";
import {
  listSchedule,
  getSchedule,
  delSchedule,
  addSchedule,
  updateSchedule,
  suListSchedule
} from "@/api/system/schedule";
import axios from 'axios'
import {listUser} from "@/api/system/user";
export default {
  name:'FindPaiban',
  components:{FullCalendar},
  data() {
    return {
      isShowBtn: false,
      dialogFormVisible:false,
      form:{
        id:"",
        userName:"",
        time:'',
      },
      formLabelWidth:120,
      calendarOptions: {
        //   timeGridPlugin  可显示每日时间段
        height: 700,
        plugins: [dayGridPlugin, interactionPlugin],
        headerToolbar: {
          left: "prev,next today",
          center: "title",
          right: "dayGridMonth,dayGridWeek,dayGrid",
          // right: 'agendaWeek,dayGridWeek,dayGrid'
        },
        buttonText: {
          // 设置按钮
          today: "今天",
          month: "月",
          week: "周",
          dayGrid: "天",
        },
        // allDaySlot: false,
        editable: true,
        selectable: true,
        navLinks: true,
        displayEventEnd: true,       //所有视图显示结束时间
        initialView: "dayGridMonth", // 设置默认显示月，可选周、日
        dateClick: this.handleDateClick,
        eventClick: this.handleEventClick,
        eventsSet: this.handleEvents,
        select: this.handleDateSelect,
        events: [],
        eventColor: "#f08f00", // 修改日程背景色
        locale: "zh-cn", // 设置语言
        weekNumberCalculation: "ISO", // 周数
        customButtons: {},
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          userId: null,
          year: null,
          month: null,
          day: null
        }
      },
      scheduleList:[],
      userList:[],
      dateRange: [],
    };
  },

  mounted(){
    this.getAllUsers();
    this.getSchedule();
  },

  methods: {
    //获取所有医生
    getAllUsers(){
      listUser(this.queryParams).then(response => {
          this.userList = response.rows;
        }
      );
    },

    //获取排班
    getSchedule(){
      suListSchedule(this.queryParams).then(response => {
        this.scheduleList = response.rows;
        this.scheduleList.forEach(d => {
          this.calendarOptions.events.push({
            id : d.id,
            start : d.time,
            end : d.time,
            color : '#2196F3',
            background : '#2196F3',
            title : d.nickName + "\n" + d.deptName
          })
        })
      });
    },
    //保存
    save(){
      this.$message.info(this.form.userId)
      addSchedule(this.form).then(response => {
        this.$modal.msgSuccess("新增成功");
        this.getSchedule();
        this.dialogFormVisible = false;
        this.form = {
          userId: "",
          time: ""
        }
      });
    },
    //点击排班事件
    handleEventClick(calEvent){
      this.isShowBtn = true;
      var data = calEvent.event;
      console.log(calEvent)
      this.form.id = data._def.extendedProps.pId,
        this.form.doctorId = data._def.extendedProps.doctorId,
        this.form.title = data.title,
        this.form.time = data._def.extendedProps.pbDate.substring(0,10),
        this.form.doctorName = data._def.extendedProps.doctorName,
        this.form.ksName = data._def.extendedProps.ksName,
        this.form.phone = data._def.extendedProps.phone
      //this.dialogFormVisible = true;
      console.log(this.dateToString(calEvent.event.start))
    },
    //添加
    addPaiban(){
      this.dialogFormVisible = true;
      this.form = {
        title:"",
        ctime:"",
        doctorId:"",
        id:'',
        doctorName:"",
        phone:"",
        ksName:''
      }
      this.isShowBtn = false;
    },
    //修改
    editPaiban(){
      this.dialogFormVisible = true;
    },
    //删除
    delData(){
      console.log(this.form)
      this.$confirm('确定要删除吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        var params = new URLSearchParams();
        params.append("pId",this.form.id);
        this.ajax.request({
          url:'/paiban/del.action',
          data:params,
          method:'post'
        }).then((res)=>{
          if(!res.data.errorcode){
            console.log(res.data);
            this.$message.success("删除成功");
            this.getSchedule();
            this.dialogFormVisible = false;
          }
        })
        this.dialogFormVisible = false;
      });
    },
    dateToString(now){
      var year = now.getFullYear();
      var month =(now.getMonth() + 1).toString();
      var day = (now.getDate()).toString();
      if (month.length == 1) {
        month = "0" + month;
      }
      if (day.length == 1) {
        day = "0" + day;
      }
      var dateTime = year + "-" + month + "-" + day;
      return dateTime;
    },
    denglu(li){
      let fd = new FormData (document.getElementById("loginform")) ;
      this.ajax.request({
        url:'/yonghu/login.action',
        data:fd,
        method:'post'
      }).then((res)=>{
        if(!res.data.errorcode){

        }
      }).catch(() => {

      })
    }
  }
}
</script>

<style scoped>

.addbtn{
  margin-top:15px;
  text-align: left;
  margin-bottom:15px;
}
.calendar_box>>>.el-dialog{
  width: 450px;
}
.calendar_box>>>.el-date-editor.el-input{
  width: 330px;
}
.el-select{
  width: 100%;
}
.detail_box>>>.el-form{
  border:1px solid #ddd;
}
.detail_box>>>.el-form-item__content{
  text-align: left;
  color: #333;
}
</style>

