(function(e){function t(t){for(var n,a,i=t[0],l=t[1],s=t[2],d=0,p=[];d<i.length;d++)a=i[d],Object.prototype.hasOwnProperty.call(o,a)&&o[a]&&p.push(o[a][0]),o[a]=0;for(n in l)Object.prototype.hasOwnProperty.call(l,n)&&(e[n]=l[n]);u&&u(t);while(p.length)p.shift()();return c.push.apply(c,s||[]),r()}function r(){for(var e,t=0;t<c.length;t++){for(var r=c[t],n=!0,i=1;i<r.length;i++){var l=r[i];0!==o[l]&&(n=!1)}n&&(c.splice(t--,1),e=a(a.s=r[0]))}return e}var n={},o={app:0},c=[];function a(t){if(n[t])return n[t].exports;var r=n[t]={i:t,l:!1,exports:{}};return e[t].call(r.exports,r,r.exports,a),r.l=!0,r.exports}a.m=e,a.c=n,a.d=function(e,t,r){a.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:r})},a.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},a.t=function(e,t){if(1&t&&(e=a(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var r=Object.create(null);if(a.r(r),Object.defineProperty(r,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var n in e)a.d(r,n,function(t){return e[t]}.bind(null,n));return r},a.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return a.d(t,"a",t),t},a.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},a.p="/";var i=window["webpackJsonp"]=window["webpackJsonp"]||[],l=i.push.bind(i);i.push=t,i=i.slice();for(var s=0;s<i.length;s++)t(i[s]);var u=l;c.push([0,"chunk-vendors"]),r()})({0:function(e,t,r){e.exports=r("56d7")},3710:function(e,t,r){"use strict";r.r(t);var n=r("7a23"),o=Object(n["createElementVNode"])("h1",null,"sticker",-1),c=[o];function a(e,t,r,o,a,i){return Object(n["openBlock"])(),Object(n["createElementBlock"])("div",null,c)}var i={name:"Sticker"},l=r("6b0d"),s=r.n(l);const u=s()(i,[["render",a]]);t["default"]=u},"56d7":function(e,t,r){"use strict";r.r(t);r("e260"),r("e6cf"),r("cca6"),r("a79d");var n=r("7a23"),o=r("c3a1"),c=(r("7437"),r("d3b7"),r("3ca3"),r("ddb0"),r("6c02")),a=[{path:"/",redirect:"/watermark"},{path:"/watermark",name:"Watermark",component:function(){return Promise.resolve().then(r.bind(null,"d33a"))}},{path:"/sticker",name:"sticker",component:function(){return Promise.resolve().then(r.bind(null,"3710"))}}],i=Object(c["a"])({history:Object(c["b"])("/"),routes:a}),l=i;function s(e,t,r,o,c,a){var i=Object(n["resolveComponent"])("Header"),l=Object(n["resolveComponent"])("router-view");return Object(n["openBlock"])(),Object(n["createElementBlock"])(n["Fragment"],null,[Object(n["createElementVNode"])("div",null,[Object(n["createVNode"])(i)]),Object(n["createVNode"])(l)],64)}var u=Object(n["createTextVNode"])("短视频去水印工具"),d=Object(n["createTextVNode"])("微信表情包工具");function p(e,t,r,o,c,a){var i=Object(n["resolveComponent"])("el-menu-item"),l=Object(n["resolveComponent"])("el-menu");return Object(n["openBlock"])(),Object(n["createBlock"])(l,{"default-active":c.path,class:"el-menu-demo",mode:"horizontal",router:""},{default:Object(n["withCtx"])((function(){return[Object(n["createVNode"])(i,{index:"/watermark"},{default:Object(n["withCtx"])((function(){return[u]})),_:1}),Object(n["createVNode"])(i,{index:"/sticker"},{default:Object(n["withCtx"])((function(){return[d]})),_:1})]})),_:1},8,["default-active"])}var b={name:"Header",data:function(){return{path:"/watermark"}},methods:{}},f=r("6b0d"),m=r.n(f);const j=m()(b,[["render",p]]);var O=j,h=r("d33a"),g=r("3710"),v={name:"Layout",components:{Header:O,Watermark:h["default"],Sticker:g["default"]}};const y=m()(v,[["render",s]]);var w=y,V=r("5502"),x=Object(V["a"])({state:{},mutations:{},actions:{},modules:{}}),C=r("c1a0");r("aede");Object(n["createApp"])(w).use(x).use(l).use(o["a"],{locale:C["a"]}).mount("#app")},"888c":function(e,t,r){"use strict";r("fe07")},aede:function(e,t,r){},d33a:function(e,t,r){"use strict";r.r(t);r("ac1f"),r("1276");var n=r("7a23"),o=function(e){return Object(n["pushScopeId"])("data-v-7594783e"),e=e(),Object(n["popScopeId"])(),e},c=Object(n["createTextVNode"])("下载"),a=Object(n["createTextVNode"])("预览"),i=o((function(){return Object(n["createElementVNode"])("span",{class:"demonstration"},"视频封面：",-1)})),l=o((function(){return Object(n["createElementVNode"])("span",{style:{color:"#999"}},"下载地址（链接仅存在1分钟，过期自动删除）：",-1)})),s={class:"dialog-footer"},u=Object(n["createTextVNode"])("确认"),d=Object(n["createTextVNode"])("> "),p=o((function(){return Object(n["createElementVNode"])("span",{style:{color:"#999999"}},"直接点击图片即可下载，展示的图片为缩略图，下载之后的为高清原图。",-1)})),b=o((function(){return Object(n["createElementVNode"])("br",null,null,-1)})),f=o((function(){return Object(n["createElementVNode"])("span",{style:{color:"#999999"}},"图片过期自动删除，请尽快操作。",-1)})),m=o((function(){return Object(n["createElementVNode"])("br",null,null,-1)})),j={class:"dialog-footer"},O=Object(n["createTextVNode"])("确认");function h(e,t,r,o,h,g){var v=this,y=Object(n["resolveComponent"])("el-image"),w=Object(n["resolveComponent"])("el-row"),V=Object(n["resolveComponent"])("el-input"),x=Object(n["resolveComponent"])("el-button"),C=Object(n["resolveComponent"])("el-popover"),N=Object(n["resolveComponent"])("el-divider"),k=Object(n["resolveComponent"])("el-link"),_=Object(n["resolveComponent"])("el-dialog"),E=Object(n["resolveComponent"])("el-carousel-item"),U=Object(n["resolveComponent"])("el-carousel");return Object(n["openBlock"])(),Object(n["createElementBlock"])(n["Fragment"],null,[Object(n["createVNode"])(w,{style:{"margin-top":"50px"},justify:"center",align:"middle"},{default:Object(n["withCtx"])((function(){return[Object(n["createVNode"])(y,{style:{width:"200px",height:"200px"},src:"https://s4.ax1x.com/2022/02/07/HMGy1e.jpg"})]})),_:1}),Object(n["createVNode"])(w,{style:{"margin-top":"10px"},justify:"center",align:"middle"},{default:Object(n["withCtx"])((function(){return[Object(n["createVNode"])(V,{modelValue:h.inputUrl,"onUpdate:modelValue":t[0]||(t[0]=function(e){return h.inputUrl=e}),placeholder:"请输入分享链接",style:{width:"40%",display:"inline-table"}},null,8,["modelValue"]),Object(n["createVNode"])(C,{placement:"top-start",width:200,trigger:"hover",content:"直接下载视频或图片"},{reference:Object(n["withCtx"])((function(){return[Object(n["createVNode"])(x,{type:"primary",style:{margin:"0 5px"},onClick:t[1]||(t[1]=function(e){return g.download()})},{default:Object(n["withCtx"])((function(){return[c]})),_:1})]})),_:1}),Object(n["createVNode"])(C,{placement:"top-start",width:200,trigger:"hover",content:"在线预览视频或图片"},{reference:Object(n["withCtx"])((function(){return[Object(n["createVNode"])(x,{type:"success",style:{margin:"0 5px"},onClick:t[2]||(t[2]=function(e){return g.preview()})},{default:Object(n["withCtx"])((function(){return[a]})),_:1})]})),_:1}),Object(n["createVNode"])(_,{modelValue:h.dialogVisible,"onUpdate:modelValue":t[4]||(t[4]=function(e){return h.dialogVisible=e}),width:"80%",title:"预览☁️"},{footer:Object(n["withCtx"])((function(){return[Object(n["createElementVNode"])("span",s,[Object(n["createVNode"])(x,{type:"success",onClick:t[3]||(t[3]=function(e){return h.dialogVisible=!1})},{default:Object(n["withCtx"])((function(){return[u]})),_:1})])]})),default:Object(n["withCtx"])((function(){return[i,Object(n["createVNode"])(y,{style:Object(n["normalizeStyle"])({width:v.video.width/10+"px",height:v.video.height/10+"px"}),src:v.previewCover},null,8,["style","src"]),Object(n["createVNode"])(N,{"border-style":"dashed"}),l,Object(n["createVNode"])(k,{href:h.previewUrl,target:"_blank",type:"success"},{default:Object(n["withCtx"])((function(){return[Object(n["createTextVNode"])(Object(n["toDisplayString"])(h.previewUrl),1)]})),_:1},8,["href"])]})),_:1},8,["modelValue"]),Object(n["createVNode"])(_,{modelValue:h.imagesDialogVisible,"onUpdate:modelValue":t[6]||(t[6]=function(e){return h.imagesDialogVisible=e}),width:"90%",title:"预览🐾"},{footer:Object(n["withCtx"])((function(){return[Object(n["createElementVNode"])("span",j,[Object(n["createVNode"])(x,{type:"success",onClick:t[5]||(t[5]=function(e){return h.dialogVisible=!1})},{default:Object(n["withCtx"])((function(){return[O]})),_:1})])]})),default:Object(n["withCtx"])((function(){return[Object(n["createVNode"])(U,{interval:2e3,type:"card",height:"200px"},{default:Object(n["withCtx"])((function(){return[(Object(n["openBlock"])(!0),Object(n["createElementBlock"])(n["Fragment"],null,Object(n["renderList"])(h.carouselList,(function(e){return Object(n["openBlock"])(),Object(n["createBlock"])(E,{key:e},{default:Object(n["withCtx"])((function(){return[Object(n["createVNode"])(y,{style:{width:"100%",height:"100%","object-fit":"contain"},src:e.url,onClick:function(t){return g.downloadFile(e.url,e.url.split("/")[1],!0)}},null,8,["src","onClick"]),d]})),_:2},1024)})),128))]})),_:1}),p,b,f,m]})),_:1},8,["modelValue"])]})),_:1})],64)}r("498a"),r("d3b7");var g=r("bc3a"),v=r.n(g),y=v.a.create({baseURL:"/api"});y.interceptors.request.use((function(e){return e.headers["Content-Type"]="application/json;charset=utf-8",e}),(function(e){return Promise.reject(e)})),y.interceptors.response.use((function(e){var t=e.data;return"blob"===e.config.responseType||"string"===typeof t&&(t=t?JSON.parse(t):t),t}),(function(e){return console.log("err"+e),Promise.reject(e)}));var w=y,V={name:"Watermark",data:function(){return{inputUrl:"",dialogVisible:!1,imagesDialogVisible:!1,previewUrl:"",previewCover:"",carouselList:[],imageUrl:"",video:{width:"108",height:"192"},image:{width:"108",height:"192"}}},methods:{download:function(){var e=this,t=this.inputUrl.trim();""!==t?(this.$message({type:"success",message:"正在解析中，请稍等片刻~🪄"}),w.post("/bare",{url:t}).then((function(t){if(200===t.code)if(e.inputUrl="","VIDEO"===t.data.type){e.$message({type:"success",message:"解析成功！作品类型为视频，正在下载！👻"});var r=t.data.videos[0].url,n=r.split("/")[1];e.downloadFile(r,n)}else if("IMAGE"===t.data.type){e.$message({type:"success",message:"解析成功！作品类型为图集，正在下载！👻"});for(var o=0;o<t.data.images.length;o++){var c=t.data.images[o].url,a=c.split("/")[1];e.downloadFile(c,a)}}else e.$message({type:"error",message:"服务器出小差了，要不等会再试试🥵"});else e.inputUrl="",e.$message({type:"error",message:"解析失败！链接错误或暂不支持该平台 😥"})}))):this.$message({message:"分享地址不能为空",type:"warning"})},preview:function(){var e=this,t=this.inputUrl.trim();""!==t?(this.$message({type:"success",message:"正在解析中，请稍等片刻~🪄"}),w.post("/bare",{url:t}).then((function(t){if(200===t.code)if(console.log(t.data),e.inputUrl="","VIDEO"===t.data.type)e.$message({type:"success",message:"解析成功！作品类型为视频!"}),e.previewCover=t.data.cover.url,e.previewUrl=t.data.videos[0].url,e.video.width=t.data.videos[0].width,e.video.height=t.data.videos[0].height,e.dialogVisible=!0,e.deleteFile(e.previewUrl);else if("IMAGE"===t.data.type){e.$message({type:"success",message:"解析成功！作品类型为图集"}),e.carouselList=t.data.images,e.imagesDialogVisible=!0;for(var r=0;r<e.carouselList.length;r++)e.deleteFile(e.carouselList[r].url)}else e.$message({type:"error",message:"服务器出小差了，要不等会再试试🥵"});else e.inputUrl="",e.$message({type:"error",message:"解析失败！链接错误或暂不支持该平台 😥"})}))):this.$message({message:"分享地址不能为空",type:"warning"})},deleteFile:function(e){setTimeout((function(){w.post("/delete",{path:e})}),6e4)},downloadFile:function(e,t,r){r&&this.$message({type:"success",message:"下载成功 🐼"});var n=document.createElement("a");n.style.display="none",n.href=e,n.setAttribute("download",t),document.body.appendChild(n),n.click(),this.deleteFile(e)}}},x=(r("888c"),r("6b0d")),C=r.n(x);const N=C()(V,[["render",h],["__scopeId","data-v-7594783e"]]);t["default"]=N},fe07:function(e,t,r){}});
//# sourceMappingURL=app.69b80569.js.map