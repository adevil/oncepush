$(function () {
     var ue = UE.getEditor('editor', {

        //工具栏上的所有的功能按钮和下拉框，可以在new编辑器的实例时选择自己需要的从新定义
        toolbars: [
            ['source', 'undo', 'redo', 'fontsize', 'removeformat', 'formatmatch',
                'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify',
                'bold', 'italic', 'underline', 'forecolor', 'backcolor', '|', 'insertorderedlist', 'insertunorderedlist', 'lineheight', '|', 'spechars', 'insertimage']]
        //是否保持toolbar的位置不动,默认true
        , autoFloatEnabled: false
        // 是否自动长高,默认true
        , autoHeightEnabled: false
        //编辑器底部距离工具栏高度(如果参数大于等于编辑器高度，则设置无效)
        , toolbarTopOffset: 100
        //初始化编辑器宽度,默认1000
        , initialFrameWidth: "100%"
        //初始化编辑器高度,默认320
        , initialFrameHeight: 400
        //编辑器拖动时最小高度,默认220
        , minFrameHeight: 400
        //停用自动保存
        , enableAutoSave: false
        , initialContent: ''
        //编辑器层级的基数,可以用来改变字体等
        , initialStyle: 'p{line-height:1em}'
        //关闭字数统计
        , wordCount: true
        //关闭elementPath
        //是否启用元素路径，默认是显示
        , elementPathEnabled: false
        //浮动时工具栏距离浏览器顶部的高度，用于某些具有固定头部的页面
        , topOffset: 0
        //编辑器层级的基数,默认是900
        , zIndex: 0
        //允许的最大字符数
        , maximumWords: 20000
        , 'insertorderedlist': {
            'num': '1,2,3...',
            'lower-alpha': 'a,b,c...',
            'lower-roman': 'i,ii,iii...',
            'upper-alpha': 'A,B,C...',
            'upper-roman': 'I,II,III...'
        }
        , insertunorderedlist: {
            'circle': '',  // '○ 小圆圈'
            'disc': '',    // '● 小圆点'
            'square': ''   //'■ 小方块'
        }
        //当鼠标放在工具栏上时显示的tooltip提示,留空支持自动多语言配置，否则以配置值为准
        , labelMap: {
            'source': '查看源代码',
            'undo': '撤销一步',
            'redo': '重做下一步',
            'bold': '字体加粗',
            'italic': '斜体字',
            'underline': '下划线',
            'forecolor': '字体颜色',
            'fontfamily': '字体',
            'justifyleft': '左对齐',
            'justifycenter': '居中对齐',
            'justifyright': '右对齐',
            'justifyjustify': '两端对齐',
            'spechars': '插入特殊符号',
            'insertorderedlist': '有序列表',
            'insertunorderedlist': '无序列表',
            'inserttable': '插入表格',
            'insertimage': '插入图片',
            'insertvideo': '插入视频',
            'emotion': '插入表情',
            'removeformat': '清除样式',
            'fullscreen': '全屏模式'
        }
    });


    //保存
    $(".save-btn").click(function () {
        console.log(ue.getContent());
        $.ajax({
            type: "post",
            url: "/sina/interface//pushWeibo.html",
            data: {content:ue.getContentTxt()},
            dataType: "json",
            success: function(data){
                alert(data);
            }
        });

    });

    $(".cancel-btn").click(function(){
        alert("cancel");
    });

});