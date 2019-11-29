//package br.com.ktrak.security.settings;
//
//import br.com.ktrak.security.services.CustomUserDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private CustomUserDetailService customUserDetailService;
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests()
////                .anyRequest()
////                .authenticated()
////                .and()
////                .httpBasic()
////                .and()
////                .csrf()
////                .disable();
////    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .cors()
//                .configurationSource(
//                        request -> new CorsConfiguration().applyPermitDefaultValues()
//                )
//            .and()
//            .csrf()
//            .disable()
//            .authorizeRequests()
//            .antMatchers(HttpMethod.POST, "/login")
//            .permitAll()
//            .and()
//            .addFilter(new JWTAuthenticationFilter(authenticationManager()))
//            .addFilter(new JWTAuthorizationFilter(authenticationManager(), customUserDetailService));
//
//
//
//    }
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
//    }
//
//
//}
