/*!
 * jquery.i18n.js
 * http://jquery.com/
 *
 * Copyright 2005, 2014 jQuery Foundation, Inc. and other contributors
 * Released under the MIT license
 * http://jquery.org/license
 *
 * Author: Aaric
 * Date: 2014-04-25T15:20Z
 * Email: vipaaric@gmail.com
 * Version: v1.0-build0015
 */
(function($){
	
	$.extend({
		i18n: function(options, callback) {
			/*Define the default parameters.*/
			var defaults = {
				url: null,
				locale: 'zh_CN'
			}
			
			/*Initialization parameter configuration*/
			var opts = $.extend(defaults, options);
			
			/*If the URL is not null, based on the system configuration for the corresponding language information*/
			if(null != opts.url) {
				$.ajax({
					type: 'GET',
					dataType: 'xml',
					url: opts.url,
					success: function(xml) {
						var key = null;
						var value = null;
						var languages = new Array();
						$(xml).find('i18n').each(function(index, object){
							key = $(object).attr('key');
							value = $(object).find('value[locale=' + opts.locale + ']:first').text();
							// console.log(key + ':' + value);
							languages[key] = value;
						});
						// console.log(languages);
						callback(languages)
					
					},
					error: function() {
						alert('Error: 404, XML loading failure!');
					}
				});
			} else {
				alert('Error: the URL can not be empty!');
			}
			
		}
	});
	
})(jQuery);