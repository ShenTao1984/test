<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- RequirJS -->
<script src="<%=request.getContextPath()%>/assets/vendors/requirejs/js/require.js"></script>

<!-- RequirJS Core Configuration -->
<script type="text/javascript">
;(function() {
  requirejs.config({
    baseUrl : '<%=request.getContextPath()%>/assets',

    urlArgs : window.urlArgs || '',
    
    waitSeconds: 15,

    paths : {
      // jQuery
      // --------------
      'jquery'           : 'vendors/jquery/js/jquery.min',
      
      // bootstrap
      // --------------
      'bootstrap'              : 'vendors/bootstrap/js/bootstrap.min',

      // Lib
      // --------------
      'underscore' : 'vendors/underscore/js/underscore-min',

      // Application Folders
      // -------------------
      'app': 'app/js'

    },
    shim : {
      // bootstrap
      // --------------
      'bootstrap'              : { deps: ['jquery'] },

      // Lib
      // -------
      'underscore' : { exports: '_' },
    }
  });
})();
</script>

