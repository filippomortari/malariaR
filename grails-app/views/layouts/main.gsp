<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title><g:layoutTitle default="Grails" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}"
	type="image/x-icon">
<link rel="apple-touch-icon"
	href="${assetPath(src: 'apple-touch-icon.png')}">
<link rel="apple-touch-icon" sizes="114x114"
	href="${assetPath(src: 'apple-touch-icon-retina.png')}">
<asset:stylesheet src="style.css" />
<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />

<asset:javascript src="application.js" />
<asset:javascript src="spring-websocket" />
<script>
        window.BASE_URL =  "${request.getContextPath()}";

</script>

<g:layoutHead />
</head>
<body class='main page' ng-app="malariaRapp">
	<!-- Navbar -->
	<div class='navbar navbar-default' id='navbar'>
		<a class='navbar-brand' href='#'> <i class='icon-bar-chart'></i> R
			script thing
		</a>
		<ul class='nav navbar-nav pull-right'>
			<!-- <li class='dropdown'><a class='dropdown-toggle'
				data-toggle='dropdown' href='#'> <i class='icon-envelope'></i>
					Messages <span class='badge'>5</span> <b class='caret'></b>
			</a>
				<ul class='dropdown-menu'>
					<li><a href='#'>New message</a></li>
					<li><a href='#'>Inbox</a></li>
					<li><a href='#'>Out box</a></li>
					<li><a href='#'>Trash</a></li>
				</ul></li>
			<li><a href='#'> <i class='icon-cog'></i> Settings
			</a></li>
			<li class='dropdown user'><a class='dropdown-toggle'
				data-toggle='dropdown' href='#'> <i class='icon-user'></i> <strong>John
						DOE</strong> <img class="img-rounded"
					src="http://placehold.it/20x20/ccc/777" /> <b class='caret'></b>
			</a>
				<ul class='dropdown-menu'>
					<li><a href='#'>Edit Profile</a></li>
					<li class='divider'></li>
					<li><a href="/">Sign out</a></li>
				</ul></li> -->
		</ul>
	</div>
	<div id='wrapper'>
		<!-- Sidebar -->
		<section id='sidebar' ng-controller="HeaderCtrl">
			<i class='icon-align-justify icon-large' id='toggle'></i>
			<ul id='dock'>
				<li ng-class="getClass('/input')" class='launcher'><i class='icon-file-text-alt'></i>
					<a ng-href="#/input">Input</a></li>
				<li class='launcher arrow'><i class='icon-long-arrow-down'></i>
					</li>
				<li ng-class="getClass('/output')" class='launcher'><i class='icon-file-text-alt'></i> <a
					ng-href="#/output">Output</a></li>
				<li class='launcher arrow'><i class='icon-long-arrow-down'></i>
					</li>
				<li ng-class="getClass('/results')" class='launcher'><i class='icon-bar-chart'></i> <a
					ng-href="#/results">Results</a></li>
				<!-- <li class='launcher'><i class='icon-table'></i> <a
					href="tables.html">Tables</a></li>
				<li class='launcher dropdown hover'><i class='icon-flag'></i> <a
					href='#'>Reports</a>
					<ul class='dropdown-menu'>
						<li class='dropdown-header'>Launcher description</li>
						<li><a href='#'>Action</a></li>
						<li><a href='#'>Another action</a></li>
						<li><a href='#'>Something else here</a></li>
					</ul></li>
				<li class='launcher'><i class='icon-bookmark'></i> <a href='#'>Bookmarks</a>
				</li>
				<li class='launcher'><i class='icon-cloud'></i> <a href='#'>Backup</a>
				</li>
				<li class='launcher'><i class='icon-bug'></i> <a href='#'>Feedback</a>
				</li> -->
			</ul>

		</section>
		<!-- Tools -->
		<section id='tools'>
			<ul class='breadcrumb' id='breadcrumb'>
				<li class='title'>Dashboard</li>
				<li><a href="#"></a></li>
			</ul>
			<!-- <div id='toolbar'>
				<div class='btn-group'>
					<a class='btn' data-toggle='toolbar-tooltip' href='#'
						title='Building'> <i class='icon-building'></i>
					</a> <a class='btn' data-toggle='toolbar-tooltip' href='#'
						title='Laptop'> <i class='icon-laptop'></i>
					</a> <a class='btn' data-toggle='toolbar-tooltip' href='#'
						title='Calendar'> <i class='icon-calendar'></i> <span
						class='badge'>3</span>
					</a> <a class='btn' data-toggle='toolbar-tooltip' href='#'
						title='Lemon'> <i class='icon-lemon'></i>
					</a>
				</div>
				<div class='label label-danger'>Danger</div>
				<div class='label label-info'>Info</div>
			</div> -->
		</section>
		<!-- Content -->
		<div id='content'>
			<g:layoutBody />

		</div>
	</div>
	<!-- Footer -->
	<!-- Javascripts -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"
		type="text/javascript"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/modernizr/2.6.2/modernizr.min.js"
		type="text/javascript"></script>
</body>
</html>
